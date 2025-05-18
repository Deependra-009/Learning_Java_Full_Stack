import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Topic2Component } from './topic-2.component';

describe('Topic2Component', () => {
  let component: Topic2Component;
  let fixture: ComponentFixture<Topic2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Topic2Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Topic2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
