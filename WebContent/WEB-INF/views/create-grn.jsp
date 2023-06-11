<html>
   <head>
      <style>
         .purchaseClass
         {
         position:relative;
         left:620px;
         }
         .purchaseClass1
         {
         position:relative;
         left:620px;
         }
         .purchaseClass2
         {
         position:relative;
         left:610px;
         }
         table {
         border-width: collapse;
         width: 100%;
         }
         #dataTable {
         width: 1000px; /* Change the width value to your desired width */
         border-collapse: collapse;
         }
         #dataTable td,
         #dataTable th {
         border: 1px solid #000; /* Change the border style and color as desired */
         padding: 8px; /* Adjust the padding as needed */
         }
         th {
         text-align: left;
         padding: 8px;
         border-bottom: 1px solid #ccc; /* Add border-bottom for table header */
         }
         label {
         font-size: 18px;
         font-weight: bold;
         color: #333;
         text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);
         padding: 10px;
         border-radius: 5px;
         }
         .purchaseClass {
         font-size: 16px;
         font-weight: bold;
         color: #fff;
         background-color: #6fbf73;
         padding: 10px 20px;
         border: none;
         border-radius: 5px;
         box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
         }
         .purchaseClass:hover {
         background-color: #4b9d54;
         }
         .purchaseClass:active {
         background-color: #3e7c46;
         }
         .addProductsClass{
         font-size: 16px;
         font-weight: bold;
         color: #fff;
         background-color: #6fbf73;
         padding: 10px 20px;
         border: none;
         border-radius: 5px;
         box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
         }
         .addProductsClass:hover {
         background-color: #4b9d54;
         }
         .addProductsClass:active {
         background-color: #3e7c46;
         }
      </style>
   </head>
   <body>
      <h1 align="center">Create GRN</h1>
      <br>
      <label class="purchaseClass1">Select VendorID:</label>
      <select id="vendorId" class="purchaseClass1" align="center" >
         <option>897</option>
      </select>
      
      <label class="purchaseClass1">Select OrderedDate:</label>
      <input type="date" id="orderedDate" class="purchaseClass1">
      
      
      <br>
      <label class="purchaseClass1">Select PurchaseID:</label>
      <select id="purchaseId" class="purchaseClass1" align="center" >
         <option>782</option>
      </select>
      
      
      
      <br><br>
      <label class="purchaseClass1">
         <h4> Purchased Items</h4>
      </label>
      <table class="table bg-white rounded shadow-sm  table-hover"  id="dataTable" align="center" >
         <thead>
            <tr>
               <th scope="col">Product Id</th>
               <th scope="col">Ordered Quantity</th>
               <th scope="col">Recieved Quantity</th>
               <th scope="col">Cost</th>
            </tr>
         </thead>
         <tbody>
            <tr>
               <td>1</td>
               <td>60</td>
               <td>30</td>
               <td>76836</td>
            </tr>
         </tbody>
      </table>
      <br><br>
      <label class="purchaseClass1">
         <h4>GRN List</h4>
      </label>
      <br>
      <table class="table bg-white rounded shadow-sm  table-hover" id="dataTable" align="center" >
         <thead id="dt">
            <tr>
               <th scope="col">Product Id</th>
               <th scope="col">Batch NO</th>
               <th scope="col">Ordered Quantity</th>
               <th scope="col">Recieved Quantity</th>
               <th scope="col">Bonus</th>
               <th scope="col">Total Quantity</th>
               <th scope="col">Cost</th>
               <th>Action</th>
            </tr>
         </thead>
         <tbody id="dataTable1"></tbody>
      </table>
      <br><br><br><br>
     
      <input type="button"  value="Create GRN" class="purchaseClass">
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
          var td7=$("<td>");
          var td8=$("<td>");
          var in1=$("<input>").attr("type","number").attr("id","prid");
          in1.css("width", "80px").css("height", "20px");
          td1.append(in1);
          
          var in2=$("<input>").attr("type","number").attr("id","batchno").text(30);
          in2.css("width", "80px").css("height", "20px");
          td2.append(in2);
          
          var in3=$("<input>").attr("type","number").attr("id","orderqty").text(30);
          in3.css("width", "80px").css("height", "20px");
          td3.append(in3);
          
          var in4=$("<input>").attr("type","number").attr("id","recieveqty");
          in4.css("width", "80px").css("height", "20px");
          td4.append(in4);
          
          var in5=$("<input>").attr("type","number").attr("id","bonus").text(30);
          in5.css("width", "80px").css("height", "20px");
          td5.append(in5);
          
          var in6=$("<input>").attr("type","number").attr("id","totalqty").text(30);
          in6.css("width", "80px").css("height", "20px");
          td6.append(in6);
          
          var in7=$("<input>").attr("type","number").attr("id","cost").text(30);
          in7.css("width", "80px").css("height", "20px");
          td7.append(in7);
          
      	var btn=$("<button>");
  		btn.text("Delete");
  		btn.on("click",function()
  		{
  			ButtonAction(this);
  			
  		});
  		
  		
  		
  		td8.append(btn);
  		tr.append(td1);
  		tr.append(td2);
  		tr.append(td3);
  		tr.append(td4);
  		tr.append(td5);
  		tr.append(td6);
  		tr.append(td7);
  		tr.append(td8);
  		
  		$("#dataTable1").append(tr);
  	
       	}
         
         function deleteRow(button) {
           var row = button.parentNode.parentNode;
           row.parentNode.removeChild(row);
         }
      </script>
   </body>
</html>