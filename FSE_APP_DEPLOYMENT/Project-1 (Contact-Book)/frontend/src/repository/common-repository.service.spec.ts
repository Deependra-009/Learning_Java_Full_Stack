import { TestBed } from '@angular/core/testing';

import { CommonRepositoryService } from './common-repository.service';

describe('CommonRepositoryService', () => {
  let service: CommonRepositoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommonRepositoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
