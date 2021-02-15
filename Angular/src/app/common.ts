import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'

})
export class Common {
    UserProfileData: any;

    private key: string = "";

    setKey(key: string) {
        this.key = key;
    }

    getKey() {
        return this.key;
    }

    getAPI(packagename, actionname) {
        if (packagename = "")
            return actionname;
        else
            return packagename  + actionname;
    }
}