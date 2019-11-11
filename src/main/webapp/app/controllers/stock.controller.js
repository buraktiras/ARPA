angular.module("crudAppStock").controller("StockController", StockController);

StockController.inject = [ '$scope', 'Stock' ];

function StockController($scope, Stock) {
	
	$scope.stocks = Stock.query();

	$scope.stock = {};
	
	$scope.buttonText="Submit";
	$scope.addNewStockButtonText="Add New Stock";
	$scope.cancelButtonText="Cancel";
	$scope.sellButtonText="Sell";
	$scope.buyButtonText="Buy";

	$scope.saveStock = function() {
		if ($scope.stock.id !== undefined) {
			Stock.update($scope.stock, function() {
				$scope.stocks = Stock.query();
				$scope.stock = {};
				$scope.buttonText="Submit";
			});
		} else {
			Stock.save($scope.stock, function() {
				$scope.stocks = Stock.query();
				$scope.stock = {};
			});
		}
	}

	$scope.updateStockInit = function(stock) {
		$scope.buttonText="Update";
		$scope.stock = stock;
	}

	$scope.deleteStock = function(stock) {
		stock.$delete({id: stock.id}, function() {
			$scope.stocks = Stock.query();
		});
	}

}
