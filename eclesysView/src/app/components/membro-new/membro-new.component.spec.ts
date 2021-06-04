import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { MembroNewComponent } from './membro-new.component';

describe('MembroNewComponent', () => {
  let component: MembroNewComponent;
  let fixture: ComponentFixture<MembroNewComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ MembroNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MembroNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
