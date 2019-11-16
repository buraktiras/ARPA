angular.module('crudAppStock').factory('StockDto', Stock);

Stock.$inject = [ '$resource' ];

function Stock($resource) {
	var resourceUrl = 'api/stock/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}

