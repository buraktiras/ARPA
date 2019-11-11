angular.module("crudAppSellOrBuy").controller("SellOrBuyController", SellOrBuyController);

SellOrBuyController.inject = [ '$scope', 'SellOrBuy' ];

function SellOrBuyController($scope, SellOrBuy) {
	
	$scope.sellOrBuys = SellOrBuy.query();

	$scope.sellOrBuy = {};
	
	$scope.buttonText="Submit";
	$scope.sellButtonText="Sell";
	$scope.buyButtonText="Buy";
	$scope.cancelButtonText="Cancel";
	
	$scope.saveSellOrBuy = function() {
		if ($scope.sellOrBuy.id !== undefined) {
			SellOrBuy.update($scope.sellOrBuy, function() {
				$scope.sellOrBuys = SellOrBuy.query();
				$scope.sellOrBuy = {};
				$scope.buttonText="Submit";
			});
		} else {
			SellOrBuy.save($scope.sellOrBuy, function() {
				$scope.sellOrBuys = SellOrBuy.query();
				$scope.sellOrBuy = {};
			});
		}
	}

	$scope.updateSellOrBuyInit = function(sellOrBuy) {
		$scope.buttonText="Update";
		$scope.sellOrBuy = sellOrBuy;
	}

	$scope.deleteSellOrBuy = function(sellOrBuy) {
		sellOrBuy.$delete({id: sellOrBuy.id}, function() {
			$scope.sellOrBuys = SellOrBuy.query();
		});
	}

}
