class FileExplorerTree{
    // id:string;
    name:string;
    type:string;
    collapse:boolean;
    childrens:FileExplorerTree[];
    constructor(name:string,type:string,children:FileExplorerTree[]){
        // this.id=id;
        this.name=name;
        this.type=type;
        this.collapse=false;
        this.childrens=children;
    }

    addFolderFile(currentNode:FileExplorerTree){
        this.collapse=true;
        this.childrens.push(currentNode);
    }

    expandFolder(){
        this.collapse=true;
    }

    collapseFolder(){
        this.collapse=false;
    }

    deleteFolder(currentNode:FileExplorerTree){
        console.log("scbhjsch",currentNode);

        this.childrens=this.childrens.filter((item:FileExplorerTree)=>item.name!=currentNode.name);
    }

}


export default FileExplorerTree;