CAMS Reference Implementation for AngularJS - Client
====================================================

# Steps to Migrate Cookbook to a Java back-end
1. Copy `Cookbook.Datatable.View/Scripts/app/*` to `*-client/src/js`
1. Copy `Cookbook.Datatable.View/Scripts/Views/*` to `*-client/src/partials`, renaming file extensions from `cshtml` to `html`
1. 

# Known Issues
* The `optimize-and-copy-lib` gulp task doesn't produce source maps that can be consumed by Chrome (or Chrome Canary). See [here](https://github.com/gulpjs/gulp/blob/master/docs/recipes/browserify-uglify-sourcemap.md) for a a possible recipe, but removing browserify. 

# To Do
1. `gulpfile.js`: fix production build; clean up. 
