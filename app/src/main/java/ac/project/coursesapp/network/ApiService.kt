package ac.project.coursesapp.network

import ac.project.coursesapp.model.BranchResponse
import ac.project.coursesapp.model.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("btech/v3/categories")
    suspend fun getCategories(): CategoryResponse

    @GET("btech/v3/branches")
    suspend fun getBranches(@Query("category") categoryId: Int): BranchResponse
}