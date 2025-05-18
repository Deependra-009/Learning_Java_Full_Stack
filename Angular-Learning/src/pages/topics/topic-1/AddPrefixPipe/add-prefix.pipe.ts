import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'addPrefix',
  standalone:true
})
export class AddPrefixPipe implements PipeTransform {

  transform(value: string, prefix: string,suffix:string): string {
    return prefix + value + suffix;
  }

}
