#author Joel Sanchez <The_Softwarriors at ESPE>

from utils.Tax import Tax


class Product:
    def __init__(self, id, descripcion, price, pvp=None):
        self._id = id
        self._descripcion = descripcion
        self._price = price
        
        if pvp is None:
            self._pvp = Tax.computeTotal(price, 15.0)
        else:
            self._pvp = pvp
    
    def __str__(self):
        return f"Product\n{{id={self._id}\n descripcion={self._descripcion}\n price={self._price}\n pvp={self._pvp}}}"
    
    def getId(self):
        return self._id
    
    def getDescripcion(self):
        return self._descripcion
    
    def getPrice(self):
        return self._price
    
    def getPvp(self):
        return self._pvp
    
    def setId(self, id):
        self._id = id
    
    def setDescripcion(self, descripcion):
        self._descripcion = descripcion
    
    def setPrice(self, price):
        self._price = price
    
    def setPvp(self, pvp):
        self._pvp = pvp