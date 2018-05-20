/**
 * 
 */
//$(function(){

// NOTE jkris above is shorthand for below line

$(document).ready(function(){

	// create new user or edit one

	$('.nBtn, .table .eBtn').on('click', function(event){

//		console.log("jkris -->");	// NOTE jkris, this is JS way to 

//		debugger;	// NOTE jkris, this is JS way of putting breakpoint hard coded into your code.If you uncomment this, this JS code will stop at this line for you to continue in debugger of DevTool of browser

		// NOTE jkris if you have href="" in anchor tag this jQuery marker triggers on, then you need to have below line to be able to see modal popup

		//         or if you have th:href="@{detail/(petId=${student.petId})}", then you need below line to stop it from showing the result as json object

		event.preventDefault();	

		var href = $(this).attr('href');

		var text = $(this).text();

		if(text=='Edit') {

			// NOTE jkris, make ajax (REST) call via jQuery's get. Then once REST service returns data (in data4cat variable) back, below function executes "asynchronously"

			$.get(href, function(data4cat, status){

				$('.myForm #petId').val(data4cat.petId);

				$('.myForm #name').val(data4cat.name);
				
				$('.myForm #type').val(data4cat.type);

				$('.myForm #owner').val(data4cat.ownerName);

				$('.myForm #address').val(data4cat.address);

				$('.myForm #birthdate').val(data4cat.birthdate);

				$('.myForm #age').val(data4cat.age);

				$('.myForm #isSpayed').val(data4cat.isSpayed);


			});

			// NOTE jkris, let Bootstrap modal popup via below jQuery call

			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')

		} else {

			// NOTE jkris, hide petId input div. And disable petId input. Since petId is "@GeneratedValue(strategy=GenerationType.AUTO)" in StudentEntity and inputs that can not be parsed to Integer will cause 400 Bad Request upon POST of form, no need for user to be able to enter anything here

			$('.myForm #petId').prop("disabled", true); // example of setting an attribute of the element

			$('.myForm #petId').prop("type", "hidden"); // NOTE this does not hide the label, just hides the input element, so below line is better

			$('.myForm #petId').parent().hide();	// NOTE jkris using jQuery APIs parent() to get parent div of #petId input and then hide() to hide that div

			// initialize the fields of modal

			$('.myForm #petId').val('');	// NOTE jkris for post form submission to be auto serialized to StudentEntity at StudentController's method, this needs to be initialized to a value that can be parsed to Integer since petId attribute is an Integer. Otherwise you will get 400 Bad Request upon POST submit

			$('.myForm #name').val('');
			
			$('.myForm #type').val('');

			$('.myForm #owner').val('');

			$('.myForm #address').val('');

			$('.myForm #birthdate').val('');

			$('.myForm #age').val('');

			$('.myForm #isSpayed').val('');

			// let Bootstrap modal popup via below jQuery call

			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')			

		}

	});

	

	$('.table .dBtn').on('click', function(event){

		event.preventDefault();	

		var href = $(this).attr('href');

		$('#exampleModal4delete #dConfBtn').attr('href', href);

		// let Bootstrap modal popup via below jQuery call

		$('#exampleModal4delete').modal();	// modal(), modal('show'), modal('toggle')			

	});		

});