//https://dev.to/unalo_baayriyo/design-a-pub-sub-pattern-in-vanilla-js-4aa1

function createBus() {
      var _cache = []
      return {
      publish:  (p1, p2) => {
          _cache = [..._cache, {[p1]:p2}]
      },
      subscribe: (p1, cb)  => {
        const result = _cache.filter((e) => e[p1]).map(e => e[p1])
              cb(result)
        }
  
    }
  }
  
  const bus = createBus();
  
  bus.publish("pay", { userId: "user_id_1", amount: 10 });
  bus.publish("check", "user_id_1");
  bus.publish("pay", { userId: "user_id_1", amount: 11 });
  
  
  //should print { userId: ‘user_id_1’, amount: 10 } and { userId: ‘user_id_1’, amount: 11 }
  bus.subscribe("pay", event => console.log(event));
  bus.subscribe("check", event => console.log(event)); // should print ‘user_id_1’