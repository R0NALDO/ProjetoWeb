
			$(function(){
				$('.btn-primary').click(function(){
						var Vnome = $('#inputNome').val(); 
						var Vsobrenome = $('#inputSobrenome').val(); 
						//var Vendereco = $('#inputEndereco').val(); 
						var Vemail = $('#inputEmail').val(); 
						$.get("ClienteController", {nome:Vnome, sobrenome:Vsobrenome, email:Vemail}, 
							function()
								{
								alert("ok");
							});
				});
			});
			