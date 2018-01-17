function showcontent(obj) {
	var that = obj;
	if (that.lastElementChild.style.display !== 'block') {
        that.lastElementChild.style.display = 'block';
    }
    else {
        that.lastElementChild.style.display = 'none';
    }
}