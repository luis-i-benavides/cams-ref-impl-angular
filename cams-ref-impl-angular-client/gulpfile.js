var gulpFilter = require('gulp-filter'),
    uglify = require('gulp-uglify'),
    cssMinify = require('gulp-minify-css'),
    sourcemaps = require('gulp-sourcemaps'),
    imagemin = require('gulp-imagemin'),
    pngcrush = require('imagemin-pngcrush'),
    less = require('gulp-less'),
    concat = require('gulp-concat'),
    gulp = require('gulp');

var paths = {
    app: './src/js',
    css: {
        files: ['src/css/*.css'],
        root: 'src/css'
    },
    less: ['src/less/*'],
    lib: './src/lib',
    assets: ["src/cache.manifest"],
    images: ["src/img/*"],
    destination: './dist'
};

// Optimize application CSS files and copy to "dist" folder
gulp.task('optimize-and-copy-css', function() {

    return gulp.src(paths.css.files)
        .pipe(cssMinify({root : paths.css.root, noRebase: true}))
        .pipe(gulp.dest(paths.destination + '/css'));
});

//Copy application JavaScript files to "dist" folder
gulp.task('optimize-and-copy-js', function() {

    return gulp
		.src(["./src/js/**/*.js", "!./src/js/**/*.min.js"])
	    .pipe(gulp.dest(paths.destination + '/js'));
});

//Optimize application main JavaScript files and copy to "dist" folder
gulp.task('optimize-and-copy-main-js', function() {

    return gulp
		.src([
	      paths.app + '/Main/app.js',
	      paths.app + '/Main/app.config.js',
	      paths.app + '/Main/app.router.js',
	      paths.app + '/Main/app.directives.js',
	      paths.app + '/Main/DataTableShellCtrl.js'
	      ], {base: 'src/js/Main'})
		.pipe(concat('app.min.js'))
	    .pipe(sourcemaps.init())
	    .pipe(uglify())
	    .pipe(sourcemaps.write('../Main'))
	    .on("error", errorHandler)
    	.pipe(gulp.dest(paths.destination + '/js/Main'));
});

// Optimize bower-managed JavaScript dependencies and copy to "dist" folder
gulp.task('optimize-and-copy-lib', function() {

	var libFiles = [
	  		      paths.lib + '/jquery/jquery.js', 
			      paths.lib + '/angular/angular.js', 
			      paths.lib + '/angular-resource/angular-resource.js',
			      paths.lib + '/angular-route/angular-route.js',
			      paths.lib + '/angular-ui-router/release/angular-ui-router.js',
			      paths.lib + '/angular-cookies/angular-cookies.js',
			      paths.lib + '/angular-bootstrap/ui-bootstrap-tpls.js',
			      paths.lib + '/angular-ui-utils/ui-utils.js',
			      paths.lib + '/oclazyload/dist/ocLazyLoad.js',
			      paths.lib + '/bootstrap/dist/js/bootstrap.js',
			      paths.lib + '/moment/moment.js',
			      paths.lib + '/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js'
			      ];
    return gulp
		.src(libFiles, { base: 'src/lib' })
		.pipe(concat('all.min.js'))
	    .pipe(sourcemaps.init())
	    .pipe(uglify())
	    .pipe(sourcemaps.write('../lib'))
	    .on("error", errorHandler)
    	.pipe(gulp.dest(paths.destination + '/lib'));
});

gulp.task('copy-images', function() {
    return gulp.src(paths.images)
        .pipe(imagemin({
            progressive: true,
            svgoPlugins: [{removeViewBox: false}],
            use: [pngcrush()]
        }))
        .pipe(gulp.dest(paths.destination + '/img'))
});

gulp.task('copy-assets', function() {
    return gulp.src(paths.assets)
        .pipe(gulp.dest(paths.destination))
});

gulp.task('build', ['optimize-and-copy-css', 'optimize-and-copy-js', 'optimize-and-copy-main-js', 'optimize-and-copy-js', 'optimize-and-copy-lib',
    'copy-images', 'copy-assets'], function(){});

//Handle the error
function errorHandler (error) {
  console.log(error.toString());
  this.emit('end');
}
