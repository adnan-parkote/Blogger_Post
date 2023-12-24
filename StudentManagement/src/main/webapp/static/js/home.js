var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

function home() {
	event.preventDefault();
	alert("Post Created");

	var serviceurl = base_url + '/createPost';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		data : {

			'title' : $('#title').val(),
			'description' : $('#description').val()
		},
		success : function(response) {

			location.reload();

		}
	});

}