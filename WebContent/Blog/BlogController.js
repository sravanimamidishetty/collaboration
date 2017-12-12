myapp.controller("BlogController",function($scope,$http)
{
	$scope.blog={blogId:1004,blogName:"",blogContent:"",createDate:"",likes:0,username:"",status:"NA"};
	
	$http.get("http://localhost:8083/SocialCollRestController/getAllBlogs")
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});
	
	$scope.insertBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post('http://localhost:8083/SocialCollRestController/insertBlog',$scope.blog)
		.then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}
});

$scope.deleteBlog=function(blogId)
{
	console.log("Entering to delete Blog");
	$http.get('http://localhost:8083/SocialCollRestController/deleteBlog/'+blogId)
success(fetchAllBlog(),function(response)
{
console.log('Succesful Deletion');
$scope.refresh();
$location.path("/Blog");
});
}
	$scope.editBlog=function(blogId)
	{
		console.log("Entering to edit Blog");
		$http.get('http://localhost:8083/SocialCollRestController/editBlog/'+blogId)
	success(fetchAllBlog(),function(response)
	{
	console.log('Editing');
	$scope.refresh();
	$location.path("/Blog");
	});
	}
	$scope.incrementLike=function(blogId)
	{
		console.log("Entering Increment Like");
		$http.get('http://localhost:8083/SocialCollRestController/incLike/'+blogId)
	success(fetchAllBlog(),function(response)
	{
	console.log('Blog like incremented');
	$scope.refresh();
	$location.path("/Blog");
	});
	}