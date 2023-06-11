<html>
<head>
    
	<style>
	
	.prnClass
	{
	position:relative;
	left:620px;
	}
	.prnfilterClass
	{
	position:relative;
	left:1040px;
	}
	</style>
    
</head>

<body>
    <h1 align="center">Create PRN</h1>
	<br><br>
		<label class="prnClass">Order Recieved date</label>
	<input type="date" id="ordrecdate" class="prnClass">
	
	<label class="prnClass">Vendor Id</label>
	<select id="vendorId" class="prnClass" >
		<option>677</option>
	</select>

	<label class="prnClass">Grn value</label>
	<select id="grnvalue" class="prnClass" >
		<option>34567</option>
		
	</select>
	<br><br>
	<label class="prnClass">Select GRN ID:</label>
	<select id="prnId" class="prnClass" align="center" >
		<option>7983834</option>
	</select>
	<br><br><br>

	<label class="prnClass"><h4>GRN Data</h4></label>
	<table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th scope="col">Product Id</th>
									<th scope="col">Batch NO</th>
									<th scope="col">Ordered Quantity</th>
									<th scope="col">Recieved Quantity</th>
									<th scope="col">Bonus</th>
									<th scope="col">Total Quantity</th>
									<th scope="col">Cost</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>1</td>
                                    <td>8634</td>
									<td>60</td>
									<td>30</td>
									<td>2</td>
									<td>32</td>
									<td>76836</td>
                                </tr>
                            </tbody>
                        </table><br><br>
<label class="prnClass"><h4>Returns List</h4></label>						
<table class="table bg-white rounded shadow-sm  table-hover" id="dataTable" >
	<thead id="dt">
         <tr>
			
			<th scope="col">Product Id</th>
			<th scope="col">Quantity</th>
			<th scope="col">Reason</th>
			<th>Action</th>
		</tr>                        
	</thead>   
  <tbody id="dataTable1">
</tbody>                        </table>
  
  
  <br><br><br><br>
 <input type="button"  value="Confirm Returns" class="prnClass">
  <script>
  function ButtonAction(button) {
		console.log("hello");
	    var row = button.parentNode.parentNode;
	    row.parentNode.removeChild(row);
	  }
 
   
   var elementsArray = $("table thead th").toArray();
   
   for(var j=0;j<6;j++)
   {
  	 console.log(j);
   	  var tr=$("<tr>");
      var td1=$("<td>");
      var td2=$("<td>");
      var td3=$("<td>");
      var td4=$("<td>");
      
      var in1=$("<input>").attr("type","number").attr("id","prid");
      in1.css("width", "80px").css("height", "20px");
      td1.append(in1);
      
      var in2=$("<input>").attr("type","number").attr("id","qty").text(30);
      in2.css("width", "80px").css("height", "20px");
      td2.append(in2);
      
      var in3=$("<input>").attr("type","text").attr("id","reason").text(30);
      in3.css("width", "300px").css("height", "50px");
      td3.append(in3);

      
  	var btn=$("<button>");
		btn.text("Delete");
		btn.on("click",function()
		{
			ButtonAction(this);
			
		});
		
		
		
		td4.append(btn);
		tr.append(td1);
		tr.append(td2);
		tr.append(td3);
		tr.append(td4);
		
		
		$("#dataTable1").append(tr);
	
   	}
    function deleteRow(button) {
      var row = button.parentNode.parentNode;
      row.parentNode.removeChild(row);
    }
  </script>

</body>

</html>