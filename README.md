# SimulationOfPort

Project of simulation of port. In this program you can a manage of existing ships, create new ships,
create new container like ContainerPrimary( for basic materials), ContainerHeavy(for heavy materials), Container Cooler( this container can cooling materials inside),
ContainerLiquidMaterials( for liquid materials), ContainerExplosiveMaterials(for explosive materials), ContainerToxicLiquidMaterials(for toxic liquid materials) and ContainerToxicLooseMaterials(for toxic loose materials).
You can add those container to magazine, ship or to railwaywagon. When railwaywagon is full, you have to wait 30 seconds for the next railwaywagon. Railwaywagon can take in one time max 10 containers.
When you want to put one of this containers(ContainerExplosiveMaterials, ContainerToxicLiquidMaterials, ContainerToxicLooseMaterial) you have to keep an eye to the time they are in the warehouse, because the sender can get a warning. 
If sender have more than 3 warnings, he can't add a next containers to the magazine.
