angular.module("crudAppEmployee").controller("EmployeeController", EmployeeController);

EmployeeController.inject = [ '$scope', 'Employee' ];

function EmployeeController($scope, Employee) {
	
	$scope.employees = Employee.query();

	$scope.employee = {};
	
	$scope.buttonText="Submit";
	$scope.addNewUserButtonText="Add New User";
	$scope.cancelUserButtonText="Cancel";
	
	$scope.saveEmployee = function() {
		if ($scope.employee.id !== undefined) {
			Employee.update($scope.employee, function() {
				$scope.employees = Employee.query();
				$scope.employee = {};
				$scope.buttonText="Submit";
			});
		} else {
			Employee.save($scope.employee, function() {
				$scope.employees = Employee.query();
				$scope.employee = {};
			});
		}
	}

	$scope.updateEmployeeInit = function(employee) {
		$scope.buttonText="Update";
		$scope.employee = employee;
	}

	$scope.deleteEmployee = function(employee) {
		employee.$delete({id: employee.id}, function() {
			$scope.employees = Employee.query();
		});
	}
	
	

	
}