<html>
   <head>
      <style>
         .indentClass
         {
         position:relative;
         left:500px;
         }
         .indentClass1
         {
         position:relative;
         left:620px;
         }
         .indentClass2
         {
         position:relative;
         left:610px;
         }
          .indentClass3
         {
         position:relative;
         left:1150px;
         
         }
         table {
         border-width: collapse;
         width: 100%;
         }
         #dt
         {
         color : green;
         }
         #indentTable
         {
         color : #4266f5;
         }
         th {
         text-align: left;
         padding: 8px;
         border-bottom: 1px solid #ccc; /* Add border-bottom for table header */
         }
      </style>
   </head>
   <body>
      <h1 align="center">Create Purchase</h1>
      <br>
      <label class="indentClass">Select IndentDate:</label>
      <input type="date" id="indentDate" class="indentClass">
	
	
	
	<label class="indentClass">IndentStatus:</label>
      <select id="vendorId" class="indentClass" align="center" >
         <option>Active</option>
      </select><br><br>
      
      <label class="indentClass">Select Indent ID:</label>
      <select id="indentId" class="indentClass" align="center">
         <option>782</option>
      </select>
      <br><br>
      <label class="indentClass1">
         <h4>Indent List</h4>
      </label>
      <table class="table bg-white rounded shadow-sm  table-hover"  >
         <thead id="indentTable">
            <tr>
               <th scope="col" width="50">#</th>
               <th scope="col">Product ID</th>
               <th scope="col"> Quatity</th>
            </tr>
         </thead>
         <tbody>
            <tr>
               <th scope="row">1</th>
               <td>Television</td>
               <td>200</td>
            </tr>
         </tbody>
      </table>
      <br><br>
      
      <label class="indentClass1">
         <h4>Purchase List</h4>
      </label>
      <br>
      <label class="indentClass3">vendor id</label>
      <select id="" class="indentClass3" >
      <option>782</option>
      </select>     
      <br>
      <table class="table bg-white rounded shadow-sm  table-hover" id="dataTable" >
         <thead id="dt">
            <tr>
               <th>Product Id</th>
               <th>Ordered Quantity</th>
               
               <th>Negotiation Price </th>
               <th>Action</th>
               <th></th>
            </tr>
         </thead>
         <tbody id="dataTable1">
         </tbody>
      </table>
      <br><br><br><br>
      
      <input type="button"  value="Create Purchase" class="indentClass1">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
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
            var td5=$("<td>");
            var td6=$("<td>");
            var in1=$("<input>").attr("type","number").attr("id","prid");
            in1.css("width", "80px").css("height", "20px");
            td1.append(in1);
            var in2=$("<input>").attr("type","number").attr("id","ordqty").text(30);
            in2.css("width", "80px").css("height", "20px");
            td2.append(in2);

            var in4=$("<input>").attr("type","number").attr("id","negprice");
            in4.css("width", "80px").css("height", "20px");
             td4.append(in4);
        	var btn=$("<button>");
    		btn.text("Delete");
    		btn.on("click",function()
    		{
    			ButtonAction(this);
    			
    		});
    		
    		
    		
    		td5.append(btn);
    		tr.append(td1);
    		tr.append(td2);
    		
    		tr.append(td4);
    		tr.append(td5);
    		
    		$("#dataTable1").append(tr);
    	
         	}
         
      </script>

   </body>
</html>