import { SharedService } from './../../services/shared.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';

@Injectable()
export class AuthGuard implements CanActivate{
    public shared: SharedService;

    constructor(private router: Router){
        this.shared = SharedService.getInstance();
    }
    
    canActivate(route: ActivatedRouteSnapshot, 
                state: RouterStateSnapshot): boolean | Observable<boolean> {
        if(this.shared.isLoggedIn()){
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }
    
}