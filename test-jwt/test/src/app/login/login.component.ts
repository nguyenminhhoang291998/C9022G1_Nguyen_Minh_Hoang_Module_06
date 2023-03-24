import {Component, OnInit} from '@angular/core';
import {UserService} from '../service/user.service';
import {FormControl, FormGroup} from '@angular/forms';
import {TokenStorageService} from '../service/token-storage.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareService} from '../service/share.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private route: ActivatedRoute,
              private shareService: ShareService
  ) {
  }

  loginForm: FormGroup;
  username: string;
  errorMessage = '';
  roles: string[] = [];
  returnUrl: string;

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams.returnUrl;
    this.loginForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl(),
      rememberMe: new FormControl(),
    });
  }

  onSubmit() {
    this.userService.login(this.loginForm.value).subscribe(data => {
        if (this.loginForm.value.rememberMe) {
          this.tokenStorageService.saveTokenLocal(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        } else {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        }

        this.userService.isLoggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.roles = this.tokenStorageService.getUser().roles;
        this.loginForm.reset();
        this.router.navigateByUrl(this.returnUrl);
        this.shareService.sendClickEvent();
      },
      err => {
        this.errorMessage = err.error.message;
        this.userService.isLoggedIn = false;
        alert('Sai tên đăng nhập hoặc mật khẩu hoặc tài khoản chưa được kích hoạt');
      });
  }
}
