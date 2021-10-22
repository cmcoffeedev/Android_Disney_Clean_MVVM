package com.interview.disney.repository

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(maxSdk = Build.VERSION_CODES.P, minSdk = Build.VERSION_CODES.P)
class DisneyTest {


    private lateinit var mMockWebServer : MockWebServer
    private val mCharacterRepository = TestCharacterRepositoryImpl()


    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        mMockWebServer = MockWebServer()
    }

    @After
    fun cleanUp() {
        mMockWebServer.shutdown()
    }



    @ExperimentalCoroutinesApi
    @Test
    fun testSingleCharacter()  {

        val response = runBlocking{ mCharacterRepository.getSingleCharacter(6)}

        Assert.assertNotNull(response)
        Assert.assertEquals("'Olu Mel", response.name )
        Assert.assertEquals(6, response.id )

    }


    @ExperimentalCoroutinesApi
    @Test
    fun testCharacters()  {


        val response = runBlocking{ mCharacterRepository.getAllCharacters()}

        Assert.assertNotNull(response)
        Assert.assertEquals(50, response.size )

    }
}