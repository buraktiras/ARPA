angular.module('crudAppSellOrBuy').factory('SellOrBuy', SellOrBuy);

SellOrBuy.$inject = [ '$resource' ];

function SellOrBuy($resource) {
	var resourceUrl = 'api/sellOrBuy/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}
