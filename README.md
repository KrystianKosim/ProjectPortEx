**

## Simulation Of Port 

**

**In this program you can** 

 - manage of existing ships
 - create new ships
 - create new container like:
	  - ContainerPrimary
	  - ContainerHeavy
	  - Container Cooler	  
	  - ContainerLiquidMaterials
	  - ContainerExplosiveMaterials
	  - ContainerToxicLiquidMaterials
	  - ContainerToxicLooseMaterials
- add those conteiner to
	 - magazine
	 - ship
	 - railwaywagon

**About railwaywagon:** 	 
 - When railwaywagon is full,  you have to wait 30 seconds for the next railwaywagon.  
 - Railwaywagon can take in one time max 10 containers.  

**About magazine** 
 - When you are creating a new magazine, you need to provide data such as:
	 - City where the warehouse will be
	 - Number, how many containeres you can stiore in this magazine
 - You have to keep an eye to the time these containers are in warehouse, becuase the sender can get an warning:
	 - ContainerExplosiveMaterials
	 - ContainerToxicLiquidMaterials
	 - ContainerToxicLooseMaterial
If sender have more than 3 warnings, he can't add a next containers to the magazine

**About sender**
 - When you want to create a new sender, you need to provide data such as:
	 - Name
	 - Surname 
	 - Pesel (program will get a birthdate from pesel)
	 - Address
	 
**About Ship**
- When you want to create a new ship, you need to provide data such as:
	- Name of this ship
	- Name of home port
	- Place from which the transport is 
	- Place to which the transport is
	- Number of maximum all containers (sum of every type containers)
	- Number of maximum heavy containers 
	- Number of maxiumum cooler containers
	- Number of maximum liquid materials containers
	- Number of maximum toxic containers
	- Maximum weight
- you can launch ship on a journey for a certain number of days 
	- when ship is in journey, you can't make any activities with this ship

**About Containers**
 - You can create one of this containers: 
	 - *Container Primary* - for basicly materials, when you want to create this containers 
	 you need to provide data such as:
		  -  Sender 
		  - Name of home port
		  -  Net Weight of the things in this container
		 - Tara
	 - *Container Heavy* - for heavy materials, when you want to create this containers 
	 you need to provide data such as:
		  - Sender
		  - Name of home port
		  - Net Weight of the things in this container
		  - Tara of this container
		  - Volume of this container
	 - *Container Cooler* this container can cooling materials inside,  when you want to create this containers 
	 you need to provide data such as:
		  - Sender
		  - Name of home port
		  - Net Weight of the things in this container
		  - Tara of this container
		  - Volume of this container
		  - Power of electricity installation of this container
	 - *Container Liquid Materials* - for liquid materials, when you want to create this containers 
	 you need to provide data such as: 
		  - Sender
		  - Name of home port
		  - Net Weight of the things in this container
		  - Tara of this container
		   - Capacity in liters
	 -  *ContainerExplosiveMaterials* - for explosive materials,  when you want to create this containers 
	 you need to provide data such as: 
		  - Sender
		  - Name of home port
		  - Net Weight of the things in this container
		  - Tara of this container
		   - Volume
		  - Certificate of explosive materials
	 - *ContainerToxicLiquidMaterials* - for toxic liquid materials, when you want to create this containers 
	 you need to provide data such as: 
		  - Sender
		  - Name of home port
		 - Net Weight of the things in this container
		 - Tara of this container
		  - Capacity in liters
		  - Certificate of toxic liquid materials
	-  ContainerToxicLooseMaterials* - for toxic loose materials, when you want to create this containers 
	 you need to provide data such as: 
		  - Sender
		  - Name of home port
		  - Net Weight of the things in this container
		  - Tara of this container
		   - Volume
		  - Certificate of toxic loose materials
