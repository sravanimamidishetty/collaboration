myapp.controller("UserController",function($scope,$http,$location){
	$scope.user={username:'',password:'',role:'',firstName:'',lastName:'',email:''}
	$scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		$http.post('http://localhost:8180/collbackend/registerUser')
		.then(function(response)
		{
			console.log('Successfully Registered');
		});
		}
	$scope.login=function(){
		console.log("Loggin Function")}
	});