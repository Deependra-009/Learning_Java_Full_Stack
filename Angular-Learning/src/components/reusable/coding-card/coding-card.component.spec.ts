import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CodingCardComponent } from './coding-card.component';

describe('CodingCardComponent', () => {
  let component: CodingCardComponent;
  let fixture: ComponentFixture<CodingCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CodingCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CodingCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
