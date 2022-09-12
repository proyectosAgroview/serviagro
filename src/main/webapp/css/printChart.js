function print(component){
  var out = document.createElement('div');
  out.appendChild(PF(component).exportAsImage()); 
  var innerHTML =  out.innerHTML;
  var openWindow = window.open('', 'Report', '');
  openWindow.document.write(innerHTML);
  openWindow.document.close();
  openWindow.focus();
  openWindow.print();
  openWindow.close();
}
									
								