<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>

<body>

  <#include "nav.ftl">

<div class="container">

<h1>Presentado por Andr�s Felipe Garc�a Cifuentes</h1>

<table>
  <tr>
    <th>Test Result</th>
  </tr>
  <tr>
    <td>${result}</td>
  </tr>

</div>

</body>
</html>
