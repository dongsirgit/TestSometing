
function onerror(message) {
	alert(message);
}
var model = (function() {
	return {
		getEntries : function(file, onend) {
			zip.createReader(new zip.BlobReader(file), function(zipReader) {
				zipReader.getEntries(onend);
			}, onerror);
		},
	};
})();
function checkzip (file){
	var flag = true;
	function bbb(){
		model.getEntries(file, function(entries) {
			entries.forEach(function(entry) {
				if(!(entry.filename.endWith('.jpg') || entry.filename.endWith('.jpeg'))){
					flag=false;
				}
			});
			function aa(){
				return flag;
			}
			return aa;
		});
	}
	alert(bafd);
//	return flag;
}



String.prototype.endWith = function (str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substring(this.length-str.length)==str)
	  return true;
	else
	  return false;
	return true;
}
