function fetchAllBlog()
{
	console.log('Fetaching All Blogs-Admin'),
	$http.get("http://localhost:8180/collbackend/getAllBlogs")
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});
};
fetchAllBlog();
$scope.rejectBlog=function(blogId)
{
	$http.get('http://localhost:8180/collbackend/rejectBlog/'+blogId)
.then(fetchAllBlog(),function(response)
{
	console.log('Blog is Rejected');
})
}
$scope.approveBlog=function(blogId)
{
	$http.get('http://localhost:8180/collbackend/approveBlog/'+blogId)
.then(fetchAllBlog(),function(response)
{
	console.log('Blog is Approved');
})

}