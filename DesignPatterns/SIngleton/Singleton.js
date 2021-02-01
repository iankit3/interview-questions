var Logger =  (function(){
    _logger = null;
    
    function getInstance(){
      if(_logger === null){
        console.log("Creating a new Logger instance");
        _logger = "WLOGGER";
      }  
      
      return _logger
    }
    
    
    return {
      getInstance: getInstance()
    }
    
  }());
  
  
  console.log(Logger.getInstance)
  console.log(Logger.getInstance)
  console.log(Logger.getInstance)
  
  
  
  
  