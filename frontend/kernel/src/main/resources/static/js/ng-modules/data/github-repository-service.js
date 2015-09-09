angular.module('data').service('githubRepository', ['url', '$http',function(url,$http,user){
	var _gitHubRepositories = null;
	this.gitHubRepositories = function(){
		return _gitHubRepositories;
	};
	this.getGitHubRepositories = function(user){
        var _getGitHubRepositoriesUrl = [url.repoUrl(),'/github'].join("");
		return $http.put(_getGitHubRepositoriesUrl,user).then(function(response){
            _gitHubRepositories = response.data === null ? '' : response.data;
			return _gitHubRepositories;
		});
	};
	this.initOnboardRepositoryUseGitHubRepository = function(repository){
		var _initRepositoryUrl = [url.repoUrl(),'/github/init'].join("");
		return $http.post(_initRepositoryUrl,repository).then(function(response){
			return response.data === null ? '' : response.data;
		});
	};

	this.getGitHubRepositoriesByOauth =  function(userId){
		var _getGitHubRepositoriesByOauthUrl = [url.repoUrl(),'/',userId,'/githubRepositories'].join("");
		return $http.get(_getGitHubRepositoriesByOauthUrl).then(function(response){
			_gitHubRepositories = response.data;
			return _gitHubRepositories;
		});
	};
}]);