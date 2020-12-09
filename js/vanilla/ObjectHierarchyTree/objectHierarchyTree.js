function objectHierarchyTree(obj, depth=0){
    if(obj.children.length > 0){
        console.log("-".repeat(depth) + obj.name)
        depth++;
        obj.children.forEach(o => {
            objectHierarchyTree(o, depth)
        });
    }else{
        console.log("-".repeat(depth) + obj.name)
    }
}
let obj = {
    name: "Some", children : [
        {name :"Some1", children: [
            {name: "Some1.1", children: []}
        ]},
        {name: "Some2", children: []},
        {name: "Some3", children: [
            {name: "Some3.1", children: []}
        ]},
    ]
}
objectHierarchyTree(obj);