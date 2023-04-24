import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Router} from '@angular/router';
import {LoginService} from '../../security-authentication/service/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;
  currentUser: string;
  accountName: string;
  role: string;
  isLoggedIn = false;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private router: Router,
              private loginService: LoginService) {
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
    this.getUsernameAccount();
  }


  ngOnInit(): void {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
    this.loadHeader();
  }

  async logOut() {
    await this.loginService.logout().subscribe(() => {
      this.tokenStorageService.signOut();
      this.shareService.sendClickEvent();
      Swal.fire({
        text: 'Đăng xuất thành công.',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('/');
      location.reload();
    }, error => {
      Swal.fire({
        text: 'Đã có lỗi xảy ra. Đăng xuất thất bại!',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

  getUsernameAccount() {
    if (this.tokenStorageService.getToken()) {
      this.accountName = this.tokenStorageService.getUser().name;
    }
  }


}
