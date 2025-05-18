import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Topic1Component } from './topic-1.component';

describe('Topic1Component', () => {
  let component: Topic1Component;
  let fixture: ComponentFixture<Topic1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Topic1Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Topic1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
