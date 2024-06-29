package com.app.flickr.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.flickr.model.Image
import com.app.flickr.model.Media
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ImageViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var imagesObserver: Observer<List<Image>>

    @Mock
    private lateinit var isLoadingObserver: Observer<Boolean>

    @Mock
    private lateinit var selectedImageObserver: Observer<Image?>

    private lateinit var viewModel: ImageViewModel

    private lateinit var closeable: AutoCloseable

    @Before
    fun setUp() {
        closeable = MockitoAnnotations.openMocks(this)
        viewModel = ImageViewModel()
        viewModel.images.observeForever(imagesObserver)
        viewModel.isLoading.observeForever(isLoadingObserver)
        viewModel.selectedImage.observeForever(selectedImageObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        closeable.close()
    }

    @Test
    fun `select image should update selectedImage`() = runTest {
        val media = Media(m = "http://example.com/image.jpg")
        val image = Image("Example Title", "http://example.com", media, "Description", "Author Name", "2021-04-01T12:00:00Z")
        viewModel.selectImage(image)

        verify(selectedImageObserver).onChanged(image)
    }

    @Test
    fun `clear selected image should clear selectedImage`() = runTest {
        viewModel.clearSelectedImage()

        verify(selectedImageObserver).onChanged(null)
    }
}
