// Connect DOM
const container = document.getElementById("container");
const menuAdmin = document.getElementById("menuAdmin");
const menuList = document.getElementById("menuList");

// fetch csrf token and header name
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute('content');
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute('content');

function fetchMenus() {
	fetch("/menu/all").then(response => response.json())
	.then(menus => {
		menuList.innerHTML = ''; // empty : to reload menu
		menus.forEach(menu => { // create each menu and add to list
			const menuItem = document.createElement('div');
			menuItem.className = 'menu-item';
			menuItem.innerHTML = `
				<a href="#" class="menu-link" style="text-decoration:none; color:black;">			
					<h3>${menu.title}</h3>
					<p>${menu.content}</p>
					<small>Writer: ${menu.writer}, Date: ${menu.indate}, Views: ${menu.count}</small>
				</a>	
				<br/>
				<br/>
				`;
				
				// when post is clicked, increment view
				menuItem.querySelector(".menu-link").addEventListener('click', (event) => {
					event.preventDefault();
					console.log(`event:${event}`);
					
					incrementCount(menu.idx).then(() => window.location.href=`/noticeCheckPage?idx=${menu.idx}`);
				});
				menuList.appendChild(menuItem);
		})
	})
}

function incrementCount(idx){
	return fetch(`/menu/count/${idx}`, {
		method: 'PUT',
		headers:{
			[csrfHeader]:csrfToken // need token since it is sending data to backend
		}
	}).then(response => {
		if(!response.ok){
			console.log("Data did not go through");
		}
	}).catch(error => {
		console.log(`Error: ${error}`);
	})
}

window.addEventListener('load', fetchMenus);