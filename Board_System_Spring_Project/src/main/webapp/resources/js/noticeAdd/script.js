const buttonSubmit = document.getElementById("buttonSubmit");

if(buttonSubmit != null){
	buttonSubmit.addEventListener("click", function(){
		 const formData = {
			memID:document.getElementById("memID").value,
			title:document.getElementById("title").value,
			content:document.getElementById("content").value,
			writer:document.getElementById("writer").value,
		 }


		const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
		const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
		
		fetch("/menu/add", {
			method:"POST",
			headers:{
				'Content-Type':'application/json',
				[csrfHeader]:csrfToken
			},
			body:JSON.stringify(formData)
		}).then(response =>{
			if(!response.ok){
				throw new Error("Failed to upload post")
			}
			return response.text();
		}).then( _ =>{
			console.log("Success");
			window.location.href="/";
			
		}).catch(error => {
			console.log("Error", error);
		});

	});
}
