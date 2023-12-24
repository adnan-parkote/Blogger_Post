var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

function signup() {
	event.preventDefault()
	alert("Registerde SuccessFully!");

	var serviceurl = base_url + '/signUp';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		data : {
			'administrator' : $('#administrator').val(),
			'username' : $('#username').val(),
			'email' : $('#email').val(),
			'contact' : $('#contact').val(),
			'gender' : $('#gender').val(),
			'password' : $('#password').val(),
		},
		success : function() {
			location.reload();
		}
	});
}