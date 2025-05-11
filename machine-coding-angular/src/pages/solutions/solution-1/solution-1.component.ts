import { Component, OnInit } from '@angular/core';
import { CommonService } from '../../../service/common/common.service';
import FileExplorerTree from './FileExplorerTree';

@Component({
  selector: 'app-solution-1',
  templateUrl: './solution-1.component.html',
  styleUrl: './solution-1.component.css',
})
export class Solution1Component implements OnInit{

  folderData=new Array<FileExplorerTree>();

  openFolderId:any=[];

  constructor(
    private commonService:CommonService
  ){}

  ngOnInit(): void {
    console.log(this.folderData);

  }

  getSvgName(key:string){
    return this.commonService.getSvgIcon(key);
  }

  collapseAllFolder(){
    this.openFolderId=[];
  }

  deleteFolder(parentFolder:FileExplorerTree,folder:FileExplorerTree){
    if(!parentFolder){
      this.folderData=this.folderData.filter((item)=>item.name !=folder.name);
      return;
    }
    parentFolder?.deleteFolder(folder);
  }

  addFolderFile(parentFolder?:FileExplorerTree){
    const name=prompt('Enter name');
    const type=prompt('Enter type (file/folder):') as 'file' | 'folder';

    // const name=parentFolder?.name+' f1';
    // const type='folder';

    if(name && type){
      const newFolder:FileExplorerTree=new FileExplorerTree(name,type.toUpperCase(),[]);

      if(parentFolder){
        parentFolder.addFolderFile(newFolder);
      }
      else{
        this.folderData.push(newFolder);
      }

    }
    else{
      alert('Invalid name or type!');
    }

    console.log(this.folderData);




  }

  openFolder(currentFolder:FileExplorerTree){

    if(!currentFolder.collapse){
      currentFolder.expandFolder();
    }
    else{
      currentFolder.collapseFolder();
    }

    // console.log(id);

    // if(this.openFolderId.includes(id)){
    //   this.openFolderId= this.openFolderId.filter((item:any)=>item!=id);
    //   console.log(this.openFolderId);

    //   return;
    // }

    // console.log(id);
    // const arr=id.split('/');
    // // this.openFolderId=[]
    // let tempId='';
    // for(let item of arr){
    //   if(tempId==''){
    //     tempId=item;
    //     this.openFolderId.push(tempId);
    //   }
    //   else{
    //     tempId+='/'+item;
    //     this.openFolderId.push(tempId);
    //   }
    // }
  }
}
