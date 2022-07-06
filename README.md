**

## Simulation Of Port 

**

**In this program you can** 

 - manage of existing ships
 - create new ships
 - create new container like:
	  - ContainerPrimary( for basic materials)  
	  - ContainerHeavy(for heavy materials)
	  - Container Cooler(this container can cooling materials inside)
	  - ContainerLiquidMaterials(for liquid materials)
	  - ContainerExplosiveMaterials(for explosive materials)
	  - ContainerToxicLiquidMaterials(for toxic liquid materials)
	  - ContainerToxicLooseMaterials(for toxic loose materials).  
 - add those conteiner to
	 - magazine
	 - ship
	 - railwaywagon

**About railwaywagon:** 	 
 - When railwaywagon is full,  you have to wait 30 seconds for the next railwaywagon.  
 - Railwaywagon can take in one time max 10 containers.  

**About magazine** 
 - When you are creating a new magazine, you can choose how many containers you can keep there.
 - You have to keep an eye to the time these containers are in warehouse, becuase the sender can get an warning:
	 - ContainerExplosiveMaterials
	 - ContainerToxicLiquidMaterials
	 - ContainerToxicLooseMaterial
If sender have more than 3 warnings, he can't add a next containers to the magazine
