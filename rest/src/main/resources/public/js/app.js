$(function() {

	$.ajax('/list').done(function(data) {
		console.log(data);
		showGraph(data);
	});
	
	function showGraph(data) {
		// create an array with nodes
		
		var nodesData = [];
		var nodesNamesIdMap = {};
		data.forEach(function(app, index) {
			nodesData.push({ id: index+1, label: app.name });
			nodesNamesIdMap[app.name] = index + 1;
		})
		var nodes = new vis.DataSet(nodesData);
	
		// create an array with edges
		var edgesData = [];
		data.forEach(function(app, index) {
			app.dependencies.forEach(function(dependency){
				edgesData.push({
					from: index + 1,
					to: nodesNamesIdMap[dependency],
					arrows: 'to'
				});
			})
		});
		var edges = new vis.DataSet(edgesData);
	
		// create a network
		var container = document.getElementById('mynetwork');
		var data = {
			nodes : nodes,
			edges : edges
		};
		var options = {};
		var network = new vis.Network(container, data, options);
	}
});