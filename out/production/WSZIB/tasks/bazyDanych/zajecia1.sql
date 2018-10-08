--1
select companyName, address, city, PostalCode, Country
from customers
where City = 'London'
order by companyName asc

--2
select companyName, address, city, PostalCode, Country
from customers
where country = 'France'
or country = 'Spain'
order by companyName asc

--3
select productName, unitprice
from products
where UnitPrice between 20.00 and 30.00

--4
select * from categories

select productName, unitprice
from products
where CategoryID = 6

--5
select productName, UnitsInStock from Products
where SupplierID = 4
order by ProductName

--6
select productName from products
where UnitsInStock = 0