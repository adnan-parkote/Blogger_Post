var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

window.onload = function() {

	var serviceurl = base_url + '/getStudentList';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		dataType : 'JSON',
		success : function(response) {
			$('#usersTable').DataTable({
//				lengthChange : !1,
//				pageLength : 10,
//				lengthChange : true,
//				lengthMenu : [ [ 10, 50, 100, -1 ],
//					[ 10, 50, 100, "All" ] ],
//				retrieve : true,
//				"scrollY": 400,
//				scrollX:false,
//				"bFilter": true,
				data : response
			});
		}
	});
}

function editStudent(id) {

	var serviceurl = base_url + '/getStudentDetails';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		dataType : 'JSON',
		data : {
			id : id
		},
		success : function(response) {
			$('#srno').val(id);
			$('#administrator').val(response.administrator);
			$('#username').val(response.username);
			$('#email').val(response.email);
			$('#contact').val(response.contact);
			$('#gender').val(response.gender);
			$('#password').val(response.password);

		}
	});
}

function updateStudent() {

	var serviceurl = base_url + '/updateStudent';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		data : {
			'srno' : $('#srno').val(),
			'administrator' : $('#administrator').val(),
			'username' : $('#username').val(),
			'email' : $('#email').val(),
			'contact' : $('#contact').val(),
			'gender' : $('#gender').val(),
			'password' : $('#password').val()
		},
		success : function() {
			location.reload();
		}
	});
}

function deleteStudent(id) {

	alert(" Deleted SuccessFully !!");

	var serviceurl = base_url + '/deleteStudent';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		data : {
			'srno' : id
		},
		success : function() {
			location.reload();
		}
	});
}
