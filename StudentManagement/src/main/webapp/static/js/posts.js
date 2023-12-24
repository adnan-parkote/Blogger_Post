var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

window.onload = function() {
	var serviceurl = base_url + '/getPostList';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		dataType : 'JSON',
		success : function(response) {
			$('#postsTable').DataTable({
				data : response
			});
		}
	});
}

function newPostCreate() {
	alert("Post Created");
	var serviceurl = base_url + '/newPost';

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

function editPost(id) {

	var serviceurl = base_url + '/getPostDetails';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		dataType : 'JSON',
		data : {
			id : id
		},
		success : function(response) {
			$('#srno').val(id);
			$('#titleedit').val(response.title);
			$('#descriptionedit').val(response.description);
		}
	});

}

function updatePost() {
	var serviceurl = base_url + '/updatePost';

	$.ajax({
		type : 'POST',
		url : serviceurl,
		data : {
			'srno' : $('#srno').val(),
			'titleupdate' : $('#titleedit').val(),
			'descriptionupdate' : $('#descriptionedit').val()
		},
		success : function() {
			location.reload();
		}
	});
}

function deletePost(id) {

	alert(" Deleted SuccessFully !!");

	var serviceurl = base_url + '/deletePost';

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