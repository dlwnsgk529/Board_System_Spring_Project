const buttonEdit = document.getElementById("buttonEdit")
const buttonDelete = document.getElementById("buttonDelete")

if(buttonEdit != null) {
	buttonEdit.addEventListener('click', function() {
		const idx = document.getElementById("idx").value;
		window.location.href=`/noticeEditPage?idx=${idx}`;
	})
}

if(buttonDelete != null) {
	buttonDelete.addEventListener('click', function() {
		const idx = document.getElementById("idx").value;
		
		const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
		const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
		
		fetch(`/menu/delete/${idx}`, {
			method:"DELETE",
			headers:{
				[csrfHeader]:csrfToken
			}
		}).then(response=>{
			if(!response.ok){
				throw new Error("Response error");
			} else {
				return response.text();
			}
		}).then(_ => {
			alert("Successfully Deleted");
			window.location.href=`/`;
		}).catch(error => {
			console.log(`Error: ${error}`);	
		})
		
	})
}
