import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {SecurityService} from '../service/security.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../service/token-storage.service';
import {ShareService} from '../service/share.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  username: string;
  // errorMessage = '';
  roles: string[] = [];
  returnUrl: string;

  constructor(private securityService: SecurityService,
              private router: Router,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl(),
      rememberMe: new FormControl()
    });

    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.securityService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }

  onSubmit() {
    this.securityService.login(this.loginForm.value).subscribe(
      data => {
        if (this.loginForm.value.rememberMe) {
          this.tokenStorageService.saveTokenLocal(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        } else {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        }

        this.securityService.isLoggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.roles = this.tokenStorageService.getUser().roles;
        this.loginForm.reset();
        alert('Đăng nhập thành công');
        this.router.navigateByUrl('home');
        this.shareService.sendClickEvent();

      },
      err => {
        // this.errorMessage = err.error.message;
        this.securityService.isLoggedIn = false;
        alert('Sai tên đăng nhập hoặc mật khẩu hoặc tài khoản chưa được kích hoạt');
      }
    );
  }
}
