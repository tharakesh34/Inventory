<html>

<head>
	<style>
	.indentClass
	{
	position:relative;
	left:620px;
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
    <h3 align="center">Create Purchase Order(Scratch)</h3><br><br>
<table class="table bg-white rounded shadow-sm  table-hover" id="dataTable" >
<thead id="dt">
                            <tr>
      <th>Product Id</th>
      <th>Ordered Quantity</th>
	  <th>Vendor Id</th>
	  <th>Negotiation Price </th>
	  <th>Action</th>
      <th></th>
    </tr>
                                
         </thead>   
  <tbody id="dataTable1">
</tbody>                        </table>
  
  
  <br><br><br><br>

  <label><b><h6>Add Products</h6></b></label>
 <div class="form-table">
    <table>
      <tr>
        <td><label for="prid">Product Id</label></td>
        <td>
			<select id="prid" class="prClass" align="center" >
				<option>7983834</option>
			</select>
		</td>
      </tr>
      <tr>
        <td><label for="qnty">Quantity</label></td>
        <td><input type="number" id="qnty" name="qnty" required></td>
      </tr>
      <tr>
        <td><label for="vid">Vendor Id</label></td>
        <td>
          <select id="vid" class="vid" align="center">
            <option>782</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="negPrice">Negotiation Price</label></td>
        <td><input type="number" id="negPrice" name="negPrice" required></td>
      </tr>
      <tr>
        
        <td>
          <button id="addProductsId" class="addProductsClass" onclick="addProducts()" >Add Product</button>
        </td>
      </tr>
    </table>
   
  </div><br><br>
 <input type="button"  value="Create Purchase" class="indentClass1">
  <script>
    document.getElementById("addProductsId").addEventListener("click", function(event) {
      event.preventDefault();
      var prid = document.getElementById("prid").value;
      var qnty = document.getElementById("qnty").value;
	  var vid = document.getElementById("vid").value;
	  var negPrice = document.getElementById("negPrice").value;
	  
	  
      var table = document.getElementById("dataTable1");
      var row = table.insertRow(-1);
      var pridCell = row.insertCell(0);
      var qntyCell = row.insertCell(1);
      var vidCell = row.insertCell(2);
	  var negPriceCell = row.insertCell(3);
	   var actionCell = row.insertCell(4);

      pridCell.innerHTML = prid;
      qntyCell.innerHTML = qnty;
	  vidCell.innerHTML = vid;
      negPriceCell.innerHTML = negPrice;
      actionCell.innerHTML = '<button class="delete-btn" onclick="deleteRow(this)">Delete</button>';

      document.getElementById("myForm").reset();
    });

    function deleteRow(button) {
      var row = button.parentNode.parentNode;
      row.parentNode.removeChild(row);
    }
  </script>

</body>

</html>